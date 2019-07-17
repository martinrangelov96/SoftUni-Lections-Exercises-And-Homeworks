package app.ccb.services;

import app.ccb.domain.dtos.bankaccount.BankAccountImportDto;
import app.ccb.domain.dtos.bankaccount.BankAccountImportRootDto;
import app.ccb.domain.entities.BankAccount;
import app.ccb.domain.entities.Client;
import app.ccb.repositories.BankAccountRepository;
import app.ccb.repositories.ClientRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    private static final String BANK_ACCOUNTS_XML_FILE_PATH = "C:\\Users\\martoraneca\\Downloads\\ColonialCouncilBank-skeleton\\ColonialCouncilBank\\src\\main\\resources\\files\\xml\\bank-accounts.xml";

    private final FileUtil fileUtil;
    private final ClientRepository clientRepository;
    private final BankAccountRepository bankAccountRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public BankAccountServiceImpl(FileUtil fileUtil, ClientRepository clientRepository, BankAccountRepository bankAccountRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.clientRepository = clientRepository;
        this.bankAccountRepository = bankAccountRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean bankAccountsAreImported() {
        return this.bankAccountRepository.count() != 0;
    }

    @Override
    public String readBankAccountsXmlFile() throws IOException {
        return this.fileUtil.readFile(BANK_ACCOUNTS_XML_FILE_PATH);
    }

    @Override
    public String importBankAccounts() throws JAXBException {
        StringBuilder importResult = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(BankAccountImportRootDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        BankAccountImportRootDto bankAccountImportRootDto
                = (BankAccountImportRootDto) unmarshaller.unmarshal(new File(BANK_ACCOUNTS_XML_FILE_PATH));

        for (BankAccountImportDto bankAccountImportDto : bankAccountImportRootDto.getBankAccountImportDtos()) {
            if (!this.validationUtil.isValid(bankAccountImportDto)) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Client clientEntity =
                    this.clientRepository.findByFullName(bankAccountImportDto.getClient())
                    .orElse(null);

            if (clientEntity == null) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            BankAccount bankAccountEntity =
                    this.modelMapper.map(bankAccountImportDto, BankAccount.class);

            bankAccountEntity.setClient(clientEntity);

            this.bankAccountRepository.saveAndFlush(bankAccountEntity);

            importResult.append(String.format("Successfully imported Bank Account - %s",
                    bankAccountEntity.getAccountNumber()))
                    .append(System.lineSeparator());

        }
        return importResult.toString().trim();
    }
}

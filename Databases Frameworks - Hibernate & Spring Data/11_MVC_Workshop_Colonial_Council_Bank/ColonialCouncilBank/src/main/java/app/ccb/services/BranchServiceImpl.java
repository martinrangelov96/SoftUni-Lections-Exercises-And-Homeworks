package app.ccb.services;

import app.ccb.domain.dtos.BranchImportDto;
import app.ccb.domain.entities.Branch;
import app.ccb.repositories.BranchRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BranchServiceImpl implements BranchService {

    private final static String BRANCHES_JSON_FILE_PATH = "C:\\Users\\martoraneca\\Downloads\\ColonialCouncilBank-skeleton\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\branches.json";

    private final FileUtil fileUtil;
    private final BranchRepository branchRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public BranchServiceImpl(FileUtil fileUtil, BranchRepository branchRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.fileUtil = fileUtil;
        this.branchRepository = branchRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() != 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        String branchesFileContent =
                this.fileUtil.readFile(BRANCHES_JSON_FILE_PATH);

        return branchesFileContent;
    }

    @Override
    public String importBranches(String branchesJson) {
        StringBuilder importResult = new StringBuilder();

        BranchImportDto[] branchImportDtos =
                this.gson.fromJson(branchesJson, BranchImportDto[].class);

        for (BranchImportDto branchImportDto : branchImportDtos) {
            if (!this.validationUtil.isValid(branchImportDto)) {
                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());

                continue;
            }

            Branch branchEntity =
                    this.modelMapper.map(branchImportDto, Branch.class);

            this.branchRepository.saveAndFlush(branchEntity);

            importResult
                    .append(String.format("Successfully imported Branch - %s", branchEntity.getName()))
                    .append(System.lineSeparator());
        }

        return importResult.toString().trim();
    }
}

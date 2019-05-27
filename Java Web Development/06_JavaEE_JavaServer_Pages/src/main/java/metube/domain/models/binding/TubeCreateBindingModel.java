package metube.domain.models.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TubeCreateBindingModel {

    private String name;
    private String description;
    private String youTubeLink;
    private String uploader;

    public TubeCreateBindingModel() {
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=[A-Za-z0-9]{11}")
    public String getYouTubeLink() {
        return youTubeLink;
    }

    public void setYouTubeLink(String youTubeLink) {
        this.youTubeLink = youTubeLink;
    }

    @NotNull
    @Size(min = 2)
    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}

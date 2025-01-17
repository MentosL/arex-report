package com.arextest.web.model.contract.contracts.filesystem;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * Created by rchen9 on 2022/12/19.
 */
@Data
public class FSSaveFolderRequestType {
    @NotBlank(message = "Folder id cannot be empty")
    private String id;
    private String workspaceId;

    private Map<String, Object> customTags;
}

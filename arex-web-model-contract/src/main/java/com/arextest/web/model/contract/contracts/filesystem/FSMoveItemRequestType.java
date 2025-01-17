package com.arextest.web.model.contract.contracts.filesystem;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class FSMoveItemRequestType {
    @NotBlank(message = "WorkspaceId cannot be empty")
    private String id;
    @NotNull(message = "From node path cannot be empty")
    @Size(message = "Source item cannot be empty")
    private String[] fromNodePath;
    private String[] toParentPath;
    private Integer toIndex;
}

package com.arextest.web.model.contract.contracts.filesystem;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class InviteToWorkspaceRequestType {
    private String invitor;
    @NotNull(message = "UserNames cannot be empty")
    private Set<String> userNames;
    @NotBlank(message = "Workspace Id cannot be empty")
    private String workspaceId;
    private Integer role;
}

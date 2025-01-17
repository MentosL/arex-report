package com.arextest.web.model.dto.filesystem;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public class FSItemDto {
    private String id;
    private String name;
    private String workspaceId;
    private String parentId;
    private Integer parentNodeType;
    private Set<String> labelIds;
    private Map<String, Object> customTags;
}

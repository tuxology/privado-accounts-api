package ai.privado.demo.accounts.service.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "NewUser")
public class BaseE implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean deleted;
    private Long version = 0L;

    public BaseE() {
        super();
    }

    // ... [Your existing constructors, getters, and setters]

    @DynamoDBHashKey(attributeName = "ID")
    public String getId() {
        return id;
    }

    @DynamoDBAttribute(attributeName = "CREATED_BY")
    public String getCreatedBy() {
        return createdBy;
    }

    // ... [Annotate other getters with @DynamoDBAttribute or @DynamoDBIndexHashKey as appropriate]

    @DynamoDBAutoGeneratedKey
    @DynamoDBHashKey(attributeName = "ID")
    public void setId(String id) {
        this.id = id;
    }

    // ... [Annotate other setters]

    @DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.CREATE)
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    @DynamoDBAutoGeneratedTimestamp(strategy = DynamoDBAutoGenerateStrategy.ALWAYS)
    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    @DynamoDBVersionAttribute
    public Long getVersion() {
        return version;
    }

    // ... [Other methods]

    // You might not need @PrePersist method since DynamoDB SDK handles the key generation
}

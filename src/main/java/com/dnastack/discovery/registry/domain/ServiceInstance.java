package com.dnastack.discovery.registry.domain;


import com.dnastack.discovery.registry.domain.converter.ZonedDateTimeAttributeConverter;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ServiceInstance {

    private String id;
    private String name;
    private String url;
    private String contactUrl;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String description;
    private List<String> aliases;
    private Map<String, String> metadata;
    private ServiceInstanceType type;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    @Convert(converter = ZonedDateTimeAttributeConverter.class)
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Convert(converter = ZonedDateTimeAttributeConverter.class)
    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Lob
    public String getDescription() {
        return description;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    public List<String> getAliases() {
        return aliases;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Enumerated(value = EnumType.STRING)
    public ServiceInstanceType getType() {
        return type;
    }

}

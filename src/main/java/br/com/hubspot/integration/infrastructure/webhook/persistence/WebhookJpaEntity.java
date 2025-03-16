package br.com.hubspot.integration.infrastructure.webhook.persistence;

import br.com.hubspot.integration.domain.webhook.Webhook;
import br.com.hubspot.integration.domain.webhook.WebhookID;
import br.com.hubspot.integration.domain.webhook.types.WebhookType;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Table(name = "webhooks")
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WebhookJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private WebhookType type;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> value;

    protected WebhookJpaEntity(
            final Long id,
            final WebhookType type,
            final Map<String, Object> value
    ) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Webhook toDomain() {
        return Webhook.with(
                WebhookID.from(String.valueOf(id)),
                type,
                value
        );
    }

}
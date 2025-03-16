package br.com.hubspot.integration.infrastructure.webhook.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebhookJpaRepository extends JpaRepository<WebhookJpaEntity, Long> {

}

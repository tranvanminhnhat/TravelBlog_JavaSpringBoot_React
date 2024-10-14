package com.travel.shahara.repositories;

import com.travel.shahara.entities.MailTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailTemplateRepository extends CrudRepository<MailTemplate, String> {
}

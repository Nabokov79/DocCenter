package ru.nabokovsg.reportservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nabokovsg.reportservice.exceptions.BadRequestException;
import ru.nabokovsg.reportservice.models.Constant;
import ru.nabokovsg.reportservice.repositoryes.ConstantRepository;

@Service
@RequiredArgsConstructor
public class ConstantServiceImpl implements ConstantService {

    private final ConstantRepository repository;

    @Override
    public Constant save(Constant constant) {
        constant.setDocument(constant.getDocument().toUpperCase());
        return repository.save(validate(constant));
    }

    private Constant validate(Constant constant) {
        if (constant.getNumber() == null) {
            exception("number in constant should not be blank");
        }
        if (constant.getNumber() < 0) {
            exception("number in constant can only be positive");
        }
        if (constant.getDocument() == null) {
            exception("document in constant should not be blank");
        }
        if (constant.getName() == null) {
            exception("name in constant should not be blank");
        }
        if (constant.getText() == null) {
            exception("text in constant should not be blank");
        }
        if (constant.getParagraph() == null) {
            exception("paragraph in constant should not be blank");
        }
        if (constant.getConclusion() == null) {
            exception("conclusion in constant should not be blank");
        }
        return constant;
    }

    private void exception(String message) {
        throw new BadRequestException(message);
    }
}

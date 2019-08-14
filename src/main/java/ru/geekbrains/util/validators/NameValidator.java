package ru.geekbrains.util.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("nameValidation")
public class NameValidator implements Validator {


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Pattern p = Pattern.compile("\\b([A-Z]\\w*)\\b");
        Matcher matcher = p.matcher(o.toString());

        if (!matcher.matches()) {
            FacesMessage msg =
                    new FacesMessage("Имя должнобыть с большой буквы.",
                            "Пожалуйста введите корректно");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);

            throw new ValidatorException(msg);
        }
    }
}

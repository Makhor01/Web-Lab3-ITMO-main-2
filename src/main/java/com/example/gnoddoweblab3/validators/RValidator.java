package com.example.gnoddoweblab3.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validateR")
public class RValidator implements Validator {
    private static final double min = 1;

    private static final double max = 3;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null,"R value is required!"));
        }

        String rString = String.valueOf(value).trim();
        if(rString.isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null,"R value is required!"));
        }

        try {
            double r = Double.parseDouble(rString);
            if (r < min || r > max) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null,"R must lie in the interval (1; 3)!"));
            }
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null,"R must be a number!"));
        }
    }

}

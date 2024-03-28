package com.example.gnoddoweblab3.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validateY")
public class YValidator implements Validator {

    private static final double min = -3;

    private static final double max = 3;

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input = String.valueOf(value).trim();
        if(input.isEmpty()) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Y value is required!"));
        }

        try {
            double y = Double.parseDouble(input);
            if (y < min || y > max) {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Y must lie in the interval (-3; 3)!"));
            }
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Y must be a number!"));
        }
    }

}

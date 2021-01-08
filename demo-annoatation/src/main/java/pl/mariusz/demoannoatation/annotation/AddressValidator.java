package pl.mariusz.demoannoatation.annotation;

import pl.mariusz.demoannoatation.model.AddressDto;
import pl.mariusz.demoannoatation.model.AddressType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static pl.mariusz.demoannoatation.model.AddressType.PRIVATE;

public class AddressValidator implements ConstraintValidator<AddressConstraint, AddressDto> {

    private String message;

    @Override
    public void initialize(AddressConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(AddressDto addressDto, ConstraintValidatorContext cxt) {
        if (addressDto == null) {
            return true;
        }

        if (AddressType.CORRESPONDING.equals(addressDto.getType())) {
            if (addressDto.getPostCode() == null || addressDto.getPostCode().trim().length() == 0){
                cxt.disableDefaultConstraintViolation();
                message = "Post code must be filled";
                cxt.buildConstraintViolationWithTemplate("{NotNull}")
                        .addNode("buildingNumber")
                        .addConstraintViolation();
                return false;
            }
        }

        if (PRIVATE.equals(addressDto.getType())) {
            if (addressDto.getCity() == null || addressDto.getCity().trim().length() == 0){
                cxt.disableDefaultConstraintViolation();
                message = "City code must be filled";
                cxt.buildConstraintViolationWithTemplate(message)
                        .addPropertyNode("type")
                        .addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}

package folder1;

import folder1.Controller.Battle;
import folder1.Controller.Direction;
import folder1.Controller.ReadFile;
import folder1.Model.*;

import javax.validation.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

/**
 * @author Nokhwezi Kholane
 */

public class App
{
    public static void main( String[] args ) {
        Archer archer = new Archer("Jayden");
        ReadFile readFile = new ReadFile();
        readFile.readPlayer(archer);

        Archer archer1 = (Archer) readFile.deserializePlayer();
        System.out.println(archer1.toString());

        //To validate a bean, we must first have a Validator object, which is constructed using a ValidatorFactory.
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        //Now that we have a Validator, we can validate our bean by passing it to the validate method.
        // Any violations of the constraints defined in the User object will be returned as a Set.
        Set<ConstraintViolation<Archer>> violations = validator.validate(archer);

        //By iterating over the violations, we can get all the violation messages by using the getMessage method.
        for (ConstraintViolation<Archer> violation : violations) {
            log.error(violation.getMessage());
        }
    }
}

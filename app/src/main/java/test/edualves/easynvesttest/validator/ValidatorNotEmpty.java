package test.edualves.easynvesttest.validator;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by edualves on 03/06/17.
 */

public class ValidatorNotEmpty {

    public static boolean isValid(String s) {

        if (StringUtils.isEmpty(s)) {
            return true;
        }
        return false;
    }

}

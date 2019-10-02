package es.iessaladillo.pedrojoya.pr01.bmi;

/**
 * Allow Bmi calculation and clasification
 */
public class BmiCalculator {

    /**
     * @param weightInKgs Weight of the person in kgs
     * @param heightInMeters Height of the person in meters
     * @return The body mass index (BMI)
     */
    public float calculateBmi(float weightInKgs, float heightInMeters) {
        // TODO
        if (heightInMeters > 0.0f && weightInKgs > 0.0f) {
            return (float)(weightInKgs / Math.pow(heightInMeters, 2.0f));
        } else {
            if (heightInMeters < 0) {
                throw new IllegalArgumentException("Negative height");
            } else if (weightInKgs < 0) {
                throw new IllegalArgumentException("Negative weight");
            } else {
                throw new IllegalArgumentException("Negative weight and height");
            }
        }
    }

    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {
        // TODO
        BmiClasification bmi_result;
        if (bmi >= 0.00f && bmi < 18.50f) {
            bmi_result = BmiClasification.LOW_WEIGHT;
        } else if (bmi >= 18.50f && bmi <= 24.99f) {
            bmi_result = BmiClasification.NORMAL_WEIGHT;
        } else if (bmi >= 25.00f && bmi <= 29.99f) {
            bmi_result = BmiClasification.OVERWWEIGHT;
        } else if (bmi >= 30.00f && bmi <= 34.99f) {
            bmi_result = BmiClasification.OBESITY_GRADE_1;
        } else if (bmi >= 35.00f && bmi < 40.00f) {
            bmi_result = BmiClasification.OBESITY_GRADE_2;
        } else if (bmi >= 40.00f) {
            bmi_result = BmiClasification.OBESITY_GRADE_3;
        } else {
            bmi_result = BmiClasification.ERROR;
        }

        return bmi_result;
    }

    public enum BmiClasification {
        ERROR, LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}

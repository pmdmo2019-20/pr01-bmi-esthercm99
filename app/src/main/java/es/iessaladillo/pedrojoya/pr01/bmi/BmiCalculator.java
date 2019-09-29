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
        return (float)(weightInKgs / Math.pow(heightInMeters, 2));
    }


    /**
     * @param bmi Body mass index to get clasification from
     * @return A BmiClasification enum with the clasification of BMI
     */
    public BmiClasification getBmiClasification(float bmi) {
        // TODO
        BmiClasification bmi_result = null;
        if (bmi < 18.5) {
            bmi_result = BmiClasification.LOW_WEIGHT;
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            bmi_result = BmiClasification.NORMAL_WEIGHT;
        } else if (bmi >= 25 && bmi <= 29.9) {
            bmi_result = BmiClasification.OVERWWEIGHT;
        } else if (bmi >= 30 && bmi <= 34.9) {
            bmi_result = BmiClasification.OBESITY_GRADE_1;
        } else if (bmi >= 35 && bmi <= 40) {
            bmi_result = BmiClasification.OBESITY_GRADE_2;
        } else if (bmi > 40) {
            bmi_result = BmiClasification.OBESITY_GRADE_3;
        }
        return bmi_result;
    }

    public enum BmiClasification {
        LOW_WEIGHT, NORMAL_WEIGHT, OVERWWEIGHT, OBESITY_GRADE_1, OBESITY_GRADE_2, OBESITY_GRADE_3
    }
}

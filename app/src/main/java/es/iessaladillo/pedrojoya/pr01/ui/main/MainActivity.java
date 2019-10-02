package es.iessaladillo.pedrojoya.pr01.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import es.iessaladillo.pedrojoya.pr01.R;
import es.iessaladillo.pedrojoya.pr01.bmi.BmiCalculator;
import es.iessaladillo.pedrojoya.pr01.utils.SoftInputUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        // TODO
        clickButtonReset();
        clickButtonCalculate();

    }

    // TODO
    private void clickButtonReset() {
        Button btnClickReset = ActivityCompat.requireViewById(this, R.id.btnReset);
        btnClickReset.setOnClickListener(r -> reset());
    }
    private void clickButtonCalculate() {
        Button btnClickCalc = ActivityCompat.requireViewById(this, R.id.btnCalculate);
        btnClickCalc.setOnClickListener(c -> showResult());
    }

    private void reset() {
        EditText height = ActivityCompat.requireViewById(this, R.id.txtHeight);
        EditText weight = ActivityCompat.requireViewById(this, R.id.txtWeight);
        ImageView image = ActivityCompat.requireViewById(this, R.id.imgBmi);
        TextView result = ActivityCompat.requireViewById(this, R.id.lblResult);

        height.setText("");
        weight.setText("");
        result.setText("");
        image.setImageResource(R.drawable.bmi);

        SoftInputUtils.hideKeyboard(this.getCurrentFocus());
    }
    private void showResult() {
        BmiCalculator bmi = new BmiCalculator();
        ImageView image = ActivityCompat.requireViewById(this, R.id.imgBmi);
        TextView result = ActivityCompat.requireViewById(this, R.id.lblResult);
        EditText weightText = ActivityCompat.requireViewById(this, R.id.txtWeight),
                 heightText = ActivityCompat.requireViewById(this, R.id.txtHeight);
        float weight, height, resultCalc;

        if(isCorrect(weightText, heightText)) {
            weight = Float.parseFloat(weightText.getText().toString());
            height = Float.parseFloat(heightText.getText().toString());
            resultCalc = bmi.calculateBmi(weight, height);

            switch (bmi.getBmiClasification(resultCalc)) {
                case LOW_WEIGHT:
                    image.setImageResource(R.drawable.underweight);
                    result.setText(getString(R.string.main_bmi, resultCalc, getString(R.string.main_underweight)));
                    break;
                case NORMAL_WEIGHT:
                    image.setImageResource(R.drawable.normal_weight);
                    result.setText(getString(R.string.main_bmi, resultCalc, getString(R.string.main_normal_weight)));
                    break;
                case OVERWWEIGHT:
                    image.setImageResource(R.drawable.overweight);
                    result.setText(getString(R.string.main_bmi, resultCalc, getString(R.string.main_overweight)));
                    break;
                case OBESITY_GRADE_1:
                    image.setImageResource(R.drawable.obesity1);
                    result.setText(getString(R.string.main_bmi, resultCalc, getString(R.string.main_obesity1)));
                    break;
                case OBESITY_GRADE_2:
                    image.setImageResource(R.drawable.obesity2);
                    result.setText(getString(R.string.main_bmi, resultCalc, getString(R.string.main_obesity2)));
                    break;
                case OBESITY_GRADE_3:
                    image.setImageResource(R.drawable.obesity3);
                    result.setText(getString(R.string.main_bmi, resultCalc, getString(R.string.main_obesity3)));
                    break;
            }
        }

        SoftInputUtils.hideKeyboard(this.getCurrentFocus());
    }

    private boolean isCorrect(EditText weightText, EditText heightText) {
        boolean isCorrectWeight = false, isCorrectHeight = false;

        if (weightText.getText().toString().isEmpty()) {
            weightText.setError(getString(R.string.main_invalid_weight));
        } else {
            if (Float.parseFloat(weightText.getText().toString()) <= 0) {
                weightText.setError(getString(R.string.main_invalid_weight));
            } else {
                isCorrectWeight = true;
            }
        }

        if (heightText.getText().toString().isEmpty()) {
            heightText.setError(getString(R.string.main_invalid_height));
        } else {
            if (Float.parseFloat(heightText.getText().toString()) <= 0) {
                heightText.setError(getString(R.string.main_invalid_height));
            } else {
                isCorrectHeight = true;
            }
        }

        return isCorrectHeight && isCorrectWeight;
    }
}

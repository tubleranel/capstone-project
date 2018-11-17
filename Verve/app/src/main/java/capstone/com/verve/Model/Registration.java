package capstone.com.verve.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.EditText;
import android.widget.Toast;
import capstone.com.verve.View.RegisterPatientActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration {


    public void registerPatient(EditText firstname, EditText middlename,
                                EditText lastname, EditText username,
                                EditText password, EditText mobile,
                                EditText email, EditText address,
                                EditText birthdate, FirebaseAuth auth, Context context) {

        String et_firstname = firstname.getText().toString().trim();
        String et_middlename = middlename.getText().toString().trim();
        String et_lastname = lastname.getText().toString().trim();
        String et_username = username.getText().toString().trim();
        String et_password = password.getText().toString().trim();
        String et_mobile = mobile.getText().toString().trim();
        String et_email = email.getText().toString().trim();
        String et_address = address.getText().toString().trim();
        String et_birthdate = birthdate.getText().toString().trim();

        if (et_firstname.isEmpty()) {
            firstname.setError("First Name is Required!");
            firstname.requestFocus();
            return;
        }

        if (et_lastname.isEmpty()) {
            lastname.setError("Last Name is Required!");
            lastname.requestFocus();
            return;
        }

        if (et_username.isEmpty()) {
            username.setError("Username is Required!");
            username.requestFocus();
            return;
        }

        if (et_mobile.length() < 11) {
            mobile.setError("Wrong Format of Phone Number!");
            mobile.requestFocus();
            return;
        }

        if (et_mobile.length() < 11) {
            mobile.setError("Wrong Format of Phone Number!");
            mobile.requestFocus();
            return;
        }


        userAndEmailAuth(et_email, et_password, context, auth);
    }

    private void userAndEmailAuth(String email, String password, final Context context, FirebaseAuth auth) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(context, message, Toast.LENGTH_LONG).show();

                        }
                    }
                });
    }


}

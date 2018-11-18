package capstone.com.verve.View

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import capstone.com.verve.Model.Users
import capstone.com.verve.Model.Registration
import capstone.com.verve.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterPatientActivity : AppCompatActivity() {

    private var auth: FirebaseAuth? = null
    internal var register: Registration? = null
    var etxt_firstname: EditText? = null
    var etxt_middlename: EditText? = null
    var etxt_lastname: EditText? = null
    var etxt_username: EditText? = null
    var etxt_password: EditText? = null
    var etxt_mobile: EditText? = null
    var etxt_email: EditText? = null
    var etxt_address: EditText? = null
    var etxt_birthdate: EditText? = null
    var rad_male: RadioButton? = null
    var rad_female: RadioButton? = null
    private var user: FirebaseUser? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_patient)
        register = Registration()
        etxt_firstname = findViewById(R.id.et_firstname)
        etxt_middlename = findViewById(R.id.et_middlename)
        etxt_lastname = findViewById(R.id.et_lastname)
        etxt_username = findViewById(R.id.et_username)
        etxt_password = findViewById(R.id.et_password)
        etxt_mobile = findViewById(R.id.et_mobile)
        etxt_email = findViewById(R.id.et_email)
        etxt_address = findViewById(R.id.et_address)
        etxt_birthdate = findViewById(R.id.et_birthday)

        rad_male = findViewById(R.id.radioMale);
        rad_female = findViewById(R.id.radioFemale)

        auth = FirebaseAuth.getInstance()


    }

    fun optionRegister(v: View) {
        val i: Intent? = null
        val chooser: Intent? = null

        if (v.id == R.id.btn_register) {
            register?.registerPatient(
                etxt_firstname,
                etxt_middlename,
                etxt_lastname,
                etxt_username,
                etxt_password,
                etxt_mobile,
                etxt_email,
                etxt_address,
                etxt_birthdate,
                rad_male,
                rad_female,
                auth,
                this@RegisterPatientActivity,
                user
            )
        }
    }


}

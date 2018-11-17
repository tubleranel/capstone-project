package capstone.com.verve.View

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast
import capstone.com.verve.Model.Patient
import capstone.com.verve.Model.Registration
import capstone.com.verve.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

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

        auth = FirebaseAuth.getInstance()


    }


    fun registerPatients() {
        val et_firstname = etxt_firstname?.text.toString().trim()
        val et_middlename = etxt_middlename?.text.toString().trim()
        val et_lastname = etxt_lastname?.text.toString().trim()
        val et_username = etxt_username?.text.toString().trim()
        val et_password = etxt_password?.text.toString().trim()
        val et_mobile = etxt_mobile?.text.toString().trim()
        val et_email = etxt_email?.text.toString().trim()
        val et_address = etxt_address?.text.toString().trim()
        val et_birthdate = etxt_birthdate?.text.toString().trim()


        if (et_firstname.isEmpty()) {
            etxt_firstname?.error = "First Name is Required!"
            etxt_firstname?.requestFocus()
            return
        }

        if (et_lastname.isEmpty()) {
            etxt_lastname?.error = "Last Name is Required!"
            etxt_lastname?.requestFocus()
            return
        }

        if (et_username.isEmpty()) {
            etxt_username?.error = "Username is Required!"
            etxt_username?.requestFocus()
            return
        }

        if (et_mobile.length < 11) {
            etxt_mobile?.error = "Wrong Format of Phone Number!"
            etxt_mobile?.requestFocus()
            return
        }


        auth!!.createUserWithEmailAndPassword(et_email, et_password)
            .addOnCompleteListener { task ->
                val message = task.exception!!.message
                if (task.isSuccessful) {


                } else {
                    Toast.makeText(this@RegisterPatientActivity, message, Toast.LENGTH_LONG).show()
                }
            }
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
                auth,
                this@RegisterPatientActivity
            )
        }
    }


}

package imageanalyzer.com.main

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.detection_chooser.*

class DetectionChooser : DialogFragment() {

    private var detectionChooserNotifierInterface: DetectionChooserNotifierInterface? = null

    interface DetectionChooserNotifierInterface {
        fun detectLabel()
        fun detectLandmark()
        fun detectFace()
        fun detectLogo()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detection_chooser, container, false)
    }

    fun addDetectionChooserNotifierInterface(listener: DetectionChooserNotifierInterface) {
        detectionChooserNotifierInterface = listener
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        detect_label.setOnClickListener {
            detectionChooserNotifierInterface?.detectLabel()
            //화면 닫는 함수 dismiss()
            dismiss()
        }
        detect_landmark.setOnClickListener {
            detectionChooserNotifierInterface?.detectLandmark()
            dismiss()
        }
        detect_face.setOnClickListener {
            detectionChooserNotifierInterface?.detectFace()
            dismiss()
        }

        detect_logo.setOnClickListener {
            detectionChooserNotifierInterface?.detectLogo()
            dismiss()
        }
        detect_cancel.setOnClickListener {
            dismiss()
        }
    }


}
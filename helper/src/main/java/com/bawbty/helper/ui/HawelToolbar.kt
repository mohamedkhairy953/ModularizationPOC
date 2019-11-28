
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View.GONE as ViewGONE
import android.view.View.VISIBLE as ViewVISIBLE

class HawelToolbar @JvmOverloads constructor(context: Context?, attrs: AttributeSet, defStyleAttrs: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttrs) {
    init {
        setupToolbar(context, attrs)
    }

    private fun setupToolbar(context: Context?, attrs: AttributeSet) {
        /*   val typedArray: TypedArray = context!!.obtainStyledAttributes(attrs, R.styleable.HawelToolbar, 0, 0)

           val toolbarTitle = typedArray.getString(R.styleable.HawelToolbar_tb_titleText)
           val hasBackButton = typedArray.getBoolean(R.styleable.HawelToolbar_tb_hasBackButton, false)
           val isTransparent = typedArray.getBoolean(R.styleable.HawelToolbar_tb_isTransparent, false)
           val isTitleCentered = typedArray.getBoolean(R.styleable.HawelToolbar_tb_isTitleCentered, true)
           val titleImage = typedArray.getInteger(R.styleable.HawelToolbar_tb_titleImage, R.drawable.ic_back)
           val hasNotificationIcon = typedArray.getBoolean(R.styleable.HawelToolbar_tb_hasNotificationIcon, false)
           val hasFilterIcon = typedArray.getBoolean(R.styleable.HawelToolbar_tb_hasFilterIcon, false)
           val hasBottomSeparator = typedArray.getBoolean(R.styleable.HawelToolbar_tb_hasBottomSeparator, true)

        typedArray.recycle()

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.view_toolbar, this)
        view.tv_title_center.text = toolbarTitle

        view.ib_back.setOnClickListener {
            if (context is Activity) {
                ActivityUtils.hideKeyboard(context)
                context.onBackPressed()
            }
        }
        if (!hasBackButton)
            view.ib_back.visibility = ViewGONE

        if (isTransparent)
            view.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))

        if (!isTitleCentered) {
            view.tv_title_center.visibility = ViewGONE
            view.tv_title_start.visibility = ViewVISIBLE
            view.tv_title_start.text = toolbarTitle
        }

        if (titleImage != R.drawable.ic_back) {
            view.iv_title_image.visibility = ViewVISIBLE
            view.iv_title_image.setImageResource(titleImage)
        }

        if (hasNotificationIcon)
            view.ib_notification.visibility = ViewVISIBLE

        if (hasFilterIcon)
            view.ib_filter.visibility = ViewVISIBLE

//        if (!hasBottomSeparator)
//            view.separator_toolbar.visibility = ViewGONE
*/
    }

}
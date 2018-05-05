package io.alekseimartoyas.webgallery.Modules.PicturesShowing.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import io.alekseimartoyas.tradetracker.Foundation.BaseActivity
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.configurator.PicturesShowingConfigurator
import io.alekseimartoyas.webgallery.Modules.PicturesShowing.view.RecyclerViewAdapter.WebImageGalleryAdapter
import io.alekseimartoyas.webgallery.R
import kotlinx.android.synthetic.main.activity_pictures_showing.*

class PicturesShowingActivity : BaseActivity<PicturesShowingActivityOutput>(), PicturesShowingActivityInput {
    override var presenter: PicturesShowingActivityOutput? = null
    var adapter: WebImageGalleryAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pictures_showing)

        PicturesShowingConfigurator(this).buildModule()

        presenter?.getPhotoListAndPushToAdapter(1,10)

        val layoutManager = GridLayoutManager(this,2)
        val recyclerView = rv_images
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = adapter!!
    }

    override fun destructor() {
        presenter?.destructor()
        presenter = null
    }

    override fun onDestroy() {
        super.onDestroy()
        destructor()
    }
}

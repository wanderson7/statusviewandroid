# Status View!

Simple Status Layout.

 	- Loading
  	- Error
  	- Default

Use it in your own code:


```sh
     	rootView = findViewById(R.id.activity_main_root);
        statusView = new StatusView(this).setRecipientLayout(rootView);

       	Set Loading Default
       	statusView.showLoadingLayout(Gravity.CENTER);

      	Set Loading Custom
      	statusView.setLoadingLayout(R.layout.layout_loading);
      	statusView.showLoadingLayout(Gravity.CENTER);

      	Set Default Layout
      	statusView.showDefaultLayout();

      	Set Error Layout
      	statusView.getDefaultDefaultErrorView().getButtonError().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Log", "Action Error");
            }
        });
        statusView.showErrorLayout(Gravity.CENTER);

```
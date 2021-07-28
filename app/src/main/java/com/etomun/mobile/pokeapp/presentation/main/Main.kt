package com.etomun.mobile.pokeapp.presentation.main

import com.etomun.mobile.pokeapp.presentation.base.Presentation


interface Main {
    interface View : Presentation.View

    interface Presenter<V : View> : Presentation.Presenter<V>
}
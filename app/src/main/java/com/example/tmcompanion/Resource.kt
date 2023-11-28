package com.example.tmcompanion

class Resource(private var value: Int, private var production: Int) {

    fun getValue(): Int{
        return this.value
    }

    fun getProduction(): Int{
        return this.production;
    }

    fun setProduction(newProd: Int){
        this.production = newProd
    }

    fun setValue(newVal: Int){
        this.value = newVal
    }
}
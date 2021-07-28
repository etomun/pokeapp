package com.etomun.mobile.pokeapp.domain.base

interface UseCase<RESULT, PARAM> {
    fun execute(param: PARAM): RESULT
}
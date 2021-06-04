package com.hemmati.namavatest.domain.usecase.base

import com.hemmati.namavatest.domain.exeption.ApiError


interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}


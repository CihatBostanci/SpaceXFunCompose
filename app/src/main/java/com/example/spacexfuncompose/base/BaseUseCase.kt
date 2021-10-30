package com.example.spacexfuncompose.base

import kotlinx.coroutines.flow.Flow

/**
* @author by cihat.bostanci
* [BaseUseCase] abstracts all Use Cases
* @param T return response
* @param in Params Params take its params
*/
abstract class BaseUseCase<in BaseUseCaseRequest, T > {

    protected abstract suspend fun buildUseCaseObservable(params:BaseUseCaseRequest): Flow<T>

    /**
     * Executes the current use case.
     */
    open suspend fun execute(params: BaseUseCaseRequest): Flow<T> {
        return this.buildUseCaseObservable(params)
    }
}

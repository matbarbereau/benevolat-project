package com.mat.benevolat.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class MembreServerExceptionHandler {

    @ExceptionHandler(MembreNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(e: MembreNotFoundException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.notFound().build()
    }
}

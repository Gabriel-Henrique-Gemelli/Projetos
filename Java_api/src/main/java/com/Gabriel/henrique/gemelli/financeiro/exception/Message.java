package com.Gabriel.henrique.gemelli.financeiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.Gabriel.henrique.gemelli.financeiro.DTO.GastoEMessage;

import jakarta.servlet.http.HttpServletRequest;

public class Message {

	// 200 OK
    public static <T> ResponseEntity<GastoEMessage<T>> ok(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.OK, "Requisição concluída com sucesso");
        return ResponseEntity.ok(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> ok(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.OK, customMsg);
        return ResponseEntity.ok(new GastoEMessage<>(data, message));
    }

    // 201 CREATED
    public static <T> ResponseEntity<GastoEMessage<T>> created(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.CREATED, "Recurso criado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> created(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.CREATED, customMsg);
        return ResponseEntity.status(HttpStatus.CREATED).body(new GastoEMessage<>(data, message));
    }

    // 400 BAD REQUEST
    public static <T> ResponseEntity<GastoEMessage<T>> badRequest(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.BAD_REQUEST, "Requisição inválida");
        return ResponseEntity.badRequest().body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> badRequest(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.BAD_REQUEST, customMsg);
        return ResponseEntity.badRequest().body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> badRequest(HttpServletRequest request, BindingResult result) {
        ApiMessage message = new ApiMessage(request, HttpStatus.BAD_REQUEST, "Erro de validação", result);
        return ResponseEntity.badRequest().body(new GastoEMessage<>(null, message));
    }

    // 401 UNAUTHORIZED
    public static <T> ResponseEntity<GastoEMessage<T>> unauthorized(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.UNAUTHORIZED, "Acesso não autorizado");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> unauthorized(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.UNAUTHORIZED, customMsg);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new GastoEMessage<>(data, message));
    }

    // 403 FORBIDDEN
    public static <T> ResponseEntity<GastoEMessage<T>> forbidden(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.FORBIDDEN, "Acesso proibido");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> forbidden(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.FORBIDDEN, customMsg);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new GastoEMessage<>(data, message));
    }

    // 404 NOT FOUND
    public static <T> ResponseEntity<GastoEMessage<T>> notFound(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.NOT_FOUND, "Recurso não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> notFound(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.NOT_FOUND, customMsg);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GastoEMessage<>(data, message));
    }

    // 500 INTERNAL SERVER ERROR
    public static <T> ResponseEntity<GastoEMessage<T>> internalError(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> internalError(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.INTERNAL_SERVER_ERROR, customMsg);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new GastoEMessage<>(data, message));
    }

    // 204 NO CONTENT
    public static <T> ResponseEntity<GastoEMessage<T>> noContent(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.NO_CONTENT, "Nenhum conteúdo para retornar");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> noContent(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.NO_CONTENT, customMsg);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new GastoEMessage<>(data, message));
    }

    // 409 CONFLICT
    public static <T> ResponseEntity<GastoEMessage<T>> conflict(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.CONFLICT, "Conflito de dados");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> conflict(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.CONFLICT, customMsg);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new GastoEMessage<>(data, message));
    }

    // 422 UNPROCESSABLE ENTITY
    public static <T> ResponseEntity<GastoEMessage<T>> unprocessableEntity(HttpServletRequest request, T data) {
        ApiMessage message = new ApiMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, "Dados inválidos ou não processáveis");
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new GastoEMessage<>(data, message));
    }

    public static <T> ResponseEntity<GastoEMessage<T>> unprocessableEntity(HttpServletRequest request, T data, String customMsg) {
        ApiMessage message = new ApiMessage(request, HttpStatus.UNPROCESSABLE_ENTITY, customMsg);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new GastoEMessage<>(data, message));
    }
}

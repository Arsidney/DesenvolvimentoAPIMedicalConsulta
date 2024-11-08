package DesenvolvimentoAPIConsulta.MedicalConsulta.exceptions;

public class ExceptionDataIntegrityViolation extends RuntimeException{
    public ExceptionDataIntegrityViolation(String message) {
        super(message);
    }
}
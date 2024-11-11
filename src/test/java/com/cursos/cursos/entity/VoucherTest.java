package com.cursos.cursos.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VoucherTest {

    @Test
    void deveCriarVoucherComCodigoValido() {
        Voucher voucher = new Voucher("VOUCHER123");
        assertEquals("VOUCHER123", voucher.getCodigo());
    }

    @Test
    void naoDeveCriarVoucherComCodigoInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Voucher(null));
        assertEquals("Código do voucher não pode ser nulo ou vazio", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> new Voucher(""));
        assertEquals("Código do voucher não pode ser nulo ou vazio", exception.getMessage());
    }

    @Test
    void vouchersComMesmoCodigoDevemSerIguais() {
        Voucher voucher1 = new Voucher("VOUCHER123");
        Voucher voucher2 = new Voucher("VOUCHER123");
        assertEquals(voucher1, voucher2);
        assertEquals(voucher1.hashCode(), voucher2.hashCode());
    }
}

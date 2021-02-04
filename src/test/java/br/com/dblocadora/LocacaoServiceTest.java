package br.com.dblocadora;

import br.com.dblocadora.entidades.Filme;
import br.com.dblocadora.entidades.Locacao;
import br.com.dblocadora.entidades.Usuario;
import br.com.dblocadora.servicos.LocacaoService;
import br.com.dblocadora.utils.DataUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class LocacaoServiceTest {

    private Filme filme;
    private Usuario usuario;
    private Locacao locacao;
    private LocacaoService service;

    @Before
    public void setup(){
        this.service = new LocacaoService();
        this.usuario = new Usuario("Usuario 1");
        this.filme = new Filme("Filme 1", 1,  5.0);
        this.locacao = service.alugarFilme(usuario, filme);
    }

    @Test
    public void deveriaLocarHoje(){
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(locacao!=null);
        assertFalse(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
        assertFalse(locacao==null);
    }

    @Test
    public void deveriaDiminuirEstoque(){
        assertEquals(1, filme.getEstoque().intValue(), 0.0001);
        assertEquals(1, filme.getEstoque(), 0.0001);
        assertEquals(Integer.valueOf(1), filme.getEstoque());

    }

    @Test
    public void mesmoObjeto(){
        assertSame(usuario, usuario);
    }

    @Test
    public void comparaStrings(){
        assertEquals(usuario.getNome(), "Usuario 1");
    }

    







}

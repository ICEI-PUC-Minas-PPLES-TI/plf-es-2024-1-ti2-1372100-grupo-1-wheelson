package com.renatomatos.wheelson.services;

// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.util.Calendar;
// import java.util.Date;

// import br.com.caelum.stella.boleto.Banco;
// import br.com.caelum.stella.boleto.Boleto;
// import br.com.caelum.stella.boleto.Datas;
// import br.com.caelum.stella.boleto.Emissor;
// import br.com.caelum.stella.boleto.Sacado;
// import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
// import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
// import org.springframework.stereotype.Service;

// @Service
// public class BoletoService {

//     private static int nossoNumero = 0;
//     @SuppressWarnings("deprecation")
//     public File generateBoleto(String nomeSacado, String cpfSacado, double valor) throws IOException {
//         Emissor emissor = Emissor.novoEmissor()
//             .comCedente("Nome do Cedente")
//             .comAgencia(1234)
//             .comDigitoAgencia('1')
//             .comContaCorrente(56789)
//             .comNumeroConvenio(1234567)
//             .comCarteira(18)
//             .comNossoNumero(nossoNumero++)
//             .comDigitoNossoNumero("0");

//         Sacado sacado = Sacado.novoSacado()
//             .comNome(nomeSacado)
//             .comCpf(cpfSacado);

//         Datas datas = Datas.novasDatas()
//             .comDocumento(Calendar.getInstance())
//             .comProcessamento(Calendar.getInstance())
//             .comVencimento(Calendar.getInstance());

//         Banco banco = new BancoDoBrasil();

//         Boleto boleto = Boleto.novoBoleto()
//             .comBanco(banco)
//             .comDatas(datas)
//             .comValorBoleto(valor)
//             .comNumeroDoDocumento("1234")
//             .comEmissor(emissor)
//             .comSacado(sacado)
//             .comInstrucoes("Senhor sacado, pague este boleto até a data de vencimento.", 
//                            "Após o vencimento, cobrar multa de 2% e juros de 1% ao mês.")
//             .comLocaisDePagamento("Pagável preferencialmente na Rede X ou em qualquer Banco até o Vencimento.");

//         GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);

//         ByteArrayOutputStream baos = new ByteArrayOutputStream();
//         gerador.geraPDF(baos);
//         File file = File.createTempFile("boleto", ".pdf");
//         try (FileOutputStream fos = new FileOutputStream(file)) {
//             baos.writeTo(fos);
//         }

//         return file;
//     }
// }

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class BoletoService {

    public File gerarBoleto(String nomeLocatario, String cpfLocatario, double valorTotal) throws DocumentException, IOException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        // Adicionar conteúdo do boleto
        Paragraph title = new Paragraph("Boleto Fictício");
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph(" ")); // Linha em branco

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);

        PdfPCell cell;

        cell = new PdfPCell(new Paragraph("Beneficiário:"));
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("WheelsOn"));
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Vencimento:"));
        table.addCell(cell);
        LocalDate vencimento = LocalDate.now().plusDays(5);
        cell = new PdfPCell(new Paragraph(vencimento.toString()));
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Valor:"));
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("R$ " + valorTotal));
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Nosso Número:"));
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("123456789"));
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Código de Barras:"));
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph("12345.67890 12345.678904 12345.678904 1 23456789012345"));
        table.addCell(cell);

        document.add(table);
        document.close();

        // Salvar o PDF em um arquivo temporário
        File file = File.createTempFile("boleto", ".pdf");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(out.toByteArray());
        }

        return file;
    }
}

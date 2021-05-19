package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("000.000.000-00")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(FuncionarioRequest.Endereco.newBuilder()
                            .setLogradouro("Rua das Tabajaras")
                            .setCep("00000-000")
                            .setComplemento("casa 20")
                            .build())
        .build()


    // escrevemos o objeto em disco ou trafegamos na rede
    println(request)
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    // lemos o objeto em disco ou mesmo na rede
    val request2 = FuncionarioRequest.newBuilder()
            .mergeFrom(FileInputStream("funcionario-request.bin"))

    request2.setCargo(Cargo.GERENTE)
        .build()
    println(request2)

}
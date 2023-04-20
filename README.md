

## :sparkles: Sistema que relaciona informações de Clientes :sparkles:

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)![spring](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)![maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)![hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)

Neste projeto, foi desenvolvido um sistema que armazena as seguintes informações sobre clientes:

* Nome;
* Endereço completo.

O endereço é acessado através da API ViaCEP, através do CEP, ou seja, o cliente precisa apenas informar o CEP e todas as informações de seu endereço são armazenadas.

Como uma das ideias é não precisar armazenar o mesmo endereço várias vezes, podendo apenas um endereço ser o mesmo para vários clientes, optou-se pela inserção de informações de complemento e referência de endereço separadamente. Essas informações, por sua vez, são únicas para cada cliente.
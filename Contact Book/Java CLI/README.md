English (United States) version first.  
Versão portuguesa (Brasil) mais abaixo.  
Version française (France) ci-dessous.

## English (United States)
All dates and times are (and have always been) in Brasília Time (UTC -3h), and in the format year-month-day.
### How to run this application
This application was written entirely in Java, and, as such, requires the Java Virtual Machine (JVM) to run.
If you don't have Java installed in your computer, you can follow the links provided in this document to download and install it.  
This app was designed to work from the command line, so this is what this document will teach you how to do.  
Before running any Java application, you must compile it. Each .java file needs to be compiled into a .class file; however, if a class depends on another, commanding your computer to compile the former will also compile the latter. As such, it is enough to run the following command:
`javac -encoding "UTF-8" ContactBook.java`  
The `-encoding "UTF-8"` part is important, because the ContactBook.java file contains characters that your JVM installation's default character encoding may not support. When compiling files written entirely in characters encoded by ASCII, specifying an encoding is not necessary; some accented latin characters may also be supported by default, though not all of them. In any case, you can, by default, try to compile a .java file without telling your computer what encoding to use, and, if the command line prints an error, you'll know to specify one.  
Then, running
`java ContactBook`
will run the application. Notice that compiling uses the command "javac", with a "c" at the end, and is given a file name with a .java extension; while running uses the command "java", without the "c", and is given a class name with no extension.
### External links
#### Java download pages
- English (unspecified locale): https://www.java.com/en/download/
- French (unspecified locale): https://www.java.com/fr/download/
- Portuguese (Brazil): https://www.java.com/pt-BR/download/
#### Guides to install Java
- English (unspecified locale): https://www.java.com/en/download/help/download_options.html
- French (unspecified locale): https://www.java.com/fr/download/help/download_options_fr.html
- Portuguese (Brazil): https://www.java.com/pt-BR/download/help/download_options_pt-br.html
### Features to supply
#### Contacts should be handled as Java classes, and stored in plain text files.
- Contact addition.
- Contact listing.
- Contact deletion.
- Contact edition.
- Contact search.
#### The interface should be offered, at least, in these languages
- English (United States).
- Portuguese (Brazil).
- French (France).
- German (Germany).
- Japanese (Japan).
- Korean (Republic of Korea).
### To do before 2022-11-20
- Write documentation that explains, at the very least, how to run the application locally. Write it in, at least, English (United States) and Portuguese (Brazil). [Finished 2022-11-17]
- Translate this file's contents to both Portuguese (Brazil) and French (France). [Finished 2022-11-17]
- Implement contact addition with Java classes. [Finished 2022-11-13]
- Verify all contact listing with Java classes is working properly; correct it, if not. [Finished 2022-11-14]
- Verify all contact deletion with Java classes is working properly; correct it, if not. [Finished 2022-11-13]
- Implement contact deletion with Java classes. [Finished 2022-11-14]
- Implement contact edition with Java classes. [Finished 2022-11-18]
### Currently working properly
- All contact deletion with Java classes. [Verified 2022-11-13]
- Contact addition with Java classes. [Since 2022-11-13]
- All contact listing with Java classes. [Since 2022-11-14]
- Individual contact deletion with Java classes. [Since 2022-11-14]
- Individual contact editing with Java classes. [Since 2022-11-18]
## Português (Brasil)
Todas as datas e horários estão (e sempre estiveram) no Horário de Brasília (UTC -3h), e no formato ano-mês-dia.
### Como rodar esta aplicação
Esta aplicação foi escrita inteiramente em Java, e, assim, requer a Java Virtual Machine (JVM) para rodar.
Se você não tem o Java instalado no seu computador, você pode seguir os links providos neste documento para baixar e instalá-lo.  
Este app foi projetado para funcionar através da linha de comando, então é isto que este documento irá lhe ensinar a fazer.  
Antes de rodar qualquer aplicação Java, você deve compilá-la. Cada arquivo .java precisa ser compilado em um arquivo .class; porém, se uma classe depende de outra, comandar o seu computador a compilar o primeiro também vai compilar o último. Assim, é suficiente rodar o seguinte comando:
`javac -encoding "UTF-8" ContactBook.java`  
A parte que diz `-encoding "UTF-8"` é importante, porque o arquivo ContactBook.java contém caracteres que a codificação padrão de caracteres, que a sua instalação da JVM usa, pode não suportar. Quando compilando arquivos escritos completamente em caracteres codificados pelo ASCII, especificar uma codificação não é necessário; alguns caracteres latinos acentuados também podem ser suportados por padrão, porém não todos. Em qualquer caso, você pode, por padrão, tentar compilar um arquivo .java sem dizer ao seu computador qual codificação usar, e, se a linha de comando imprimir um erro, você saberá que deve especificar uma.  
Depois disso, rodar
`java ContactBook`
vai rodar a aplicação. Note que compilar usa o comand "javac", com um "c" no final, e recebe um arquivo com uma extensão .java; enquanto que rodar usa o comando "java", sem o "c", e recebe um nome de uma classe, este nome não tendo qualquer extensão.
### Links externos
#### Páginas de download do Java
- Inglês (local não especificado): https://www.java.com/en/download/
- Francês (local não especificado): https://www.java.com/fr/download/
- Português (Brasil): https://www.java.com/pt-BR/download/
#### Guias para instalar a Java
- Inglês (local não especificado): https://www.java.com/en/download/help/download_options.html
- Francês (local não especificado): https://www.java.com/fr/download/help/download_options_fr.html
- Português (Brasil): https://www.java.com/pt-BR/download/help/download_options_pt-br.html
### Recursos a prover
#### Com os contatos deve-se lidar manuseando classes do Java. Os contatos devem ser armazenados em arquivos de texto não-formatado.
- Adição de contatos.
- Listagem de contatos.
- Deleção de contatos.
- Edição de contatos.
- Pesquisa de contatos.
#### A interface deve ser oferecida, pelo menos, nestas línguas
- Inglês (Estados Unidos).
- Português (Brasil).
- Francês (França).
- Alemão (Alemanha).
- Japonês (Japão).
- Coreano (República da Coreia).
### A fazer antes de 2022-11-20
- Escrever documentação que explique, no mínimo, como localmente rodar a aplicação. Escrevê-la em, pelo menos, inglês (Estados Unidos) e português (Brasil). [Finalizado 2022-11-17]
- Traduzir os conteúdos deste arquivo para o português (Brasil) e o francês (França). [Finalizado 2022-11-17]
- Implementar adição de contatos com classes do Java. [Finalizado 2022-11-13]
- Verificar que a listagem, com classes do Java, de todos os contatos está funcionando corretamente; corrigí-la, se não estiver. [Finalizado 2022-11-14]
- Verificar que a deleção, com classes do Java, de todos os contatos está funcionando corretamente; corrigí-la, se não estiver. [Finalizado 2022-11-13]
- Implementar deleção de contatos com classes do Java. [Finalizado 2022-11-14]
- Implementar edição de contatos com classes do Java. [Finalizado 2022-11-18]
### Atualmente funcionando corretamente
- Deleção, com classes do Java, de todos os contatos. [Verificado 2022-11-13. Refeito 2022-11-14]
- Adição, com classes do Java, de contatos novos. [Desde 2022-11-13]
- Listagem, com classes do Java, de todos os contatos. [Desde 2022-11-14]
- Deleção, com classes do Java, de contatos individuais. [Desde 2022-11-14]
- Edição, com classes do Java, de contatos individuais. [Desde 2022-11-18]
## Français (France)
Tous les dates et horaires sont (et toujours étaient) au Horaire de Brasília (UTC -3h), et au format année-mois-jour.
### Features à prover
#### Il faut utiliser classes du Java pour manipuler les contacts. Les contacts doivent être sauvegardés en fichiers de texte brut.
- Ajoute des contacts.
- Listage des contacts.
- Suppression des contacts.
- Édition des contacts.
- Cherche pour les contacts.
#### L'interface doive être offertée, au moins, en ces langues
- Anglais (États Unis).
- Portugais (Brésil).
- Français (France).
- Allemand (Allemagne).
- Japonais (Japon).
- Coréen (Republique de Corée).
### À faire avant le 2022-11-20
- Écrire documentation qui explique, au moins, comment localement exécuter l'application. La écrire en, au moins, anglais (États Unis) et Portugais (Brésil). [Fini le 2022-11-17]
- Traduire les contenus de ce fichier au portugais (Brésil) et au français (France). [Fini le 2022-11-17]
- Implémenter l'ajoute des contacts avec les classes du Java. [Fini le 2022-11-13]
- Vérifier que la listage, avec les classes du Java, de tous les contacts est à fonctionner correctement; la corrigire, au contraire. [Fini le 2022-11-14]
- Vérifier que la suppression, avec les classes du Java, de tous les contacts est à fonctionner correctement; la corrigire, au contraire. [Fini le 2022-11-13]
- Implémenter la suppression des contats avec les classes du Java. [Fini le 2022-11-14]
- Implémenter la édition des contacts avec les classes du Java. [Fini le 2022-11-18]
### Actuellement à fonctionner correctement
- Suppression, avec les classes du Java, de tous les contacts. [Verifié le 2022-11-13. Refait le 2022-11-14]
- Ajoute, avec les classes du Java, des nouveaux contacts. [Depuis le 2022-11-13]
- Listage, avec les classes du Java, de tous les contacts. [Depuis le 2022-11-14]
- Suppression, avec les classes du Java, des contacts individuels. [Depuis le 2022-11-14]
- Édition, avec les classes du Java, des contacts individuels. [Depuis le 2022-11-18]

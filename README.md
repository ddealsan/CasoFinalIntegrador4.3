## Link del repositorio
https://github.com/ddealsan/CasoFinalIntegrador4.3.git
# Resumen del Proyecto

Este proyecto es un editor de texto simple con características adicionales. Se desarrolló utilizando Java y Maven.

## Características

1. **Edición de texto**: La característica principal de este proyecto es un editor de texto donde los usuarios pueden escribir y editar texto.

2. **Guardar archivos**: Los usuarios pueden guardar su trabajo en un archivo. Todos los archivos se guardan con una extensión `.txt`.

3. **Borrar texto**: Hay una característica para borrar todo el texto en el editor.

4. **Herramienta de dibujo**: El proyecto incluye una herramienta de dibujo que se abre en una nueva ventana.

5. **Conteo de palabras**: La aplicación cuenta el número de palabras en el editor de texto y lo muestra.

6. **Botones de salida y cancelación**: Hay opciones para salir de la aplicación. Si hay cambios sin guardar, la aplicación solicitará al usuario que guarde antes de salir.

## Cómo ejecutar

Para ejecutar el proyecto, ejecute la clase `Main` ubicada en `src/main/java/org/example/Main.java`. Esto abrirá la `WelcomeScreen`.

## Estructura del código

El proyecto se divide en varios paquetes:

- `TextEditor`: Contiene la clase `TextEditor` que es el componente principal del proyecto. Incluye el editor de texto, botones para varias características y la funcionalidad de conteo de palabras.

- `DrawingTool`: Contiene la clase `DrawingTool` que es una herramienta de dibujo simple que se abre en una nueva ventana.

- `WelcomeScreen`: Contiene la clase `WelcomeScreen` que es el punto de entrada de la aplicación.

- `EmailValidator`: Contiene la clase `EmailValidator` que es un validador de correo electrónico simple y administrador de contactos. Permite agregar, eliminar y modificar contactos. Los contactos se guardan en un archivo y se cargan cuando se inicia la aplicación.

## Dependencias

Este proyecto utiliza Java y Maven. Asegúrate de tenerlos instalados en tu sistema para ejecutar el proyecto.

# SoundCraft --- Registro de prompts del Seminario

**Proyecto:** SoundCraft\
**Repositorio:** https://github.com/MariaLuzPaezTello/SoundCraft\
**Entorno:** Android Studio Quail 3 (2026.1.3)\
**Tecnologías:** Kotlin, Jetpack Compose y Material 3\
**Tipo de entrega:** prototipo visual e interactivo para Android

------------------------------------------------------------------------

## 1. Objetivo del documento

Este documento reúne los prompts utilizados y reconstruidos durante el
proceso de definición, diseño e implementación del prototipo SoundCraft.
Se organiza por etapas para mostrar cómo se pasó de la idea inicial a
una aplicación Android con cuatro pantallas conectadas.

**Nota sobre la literalidad:** no se conserva el texto exacto de todos
los mensajes originales de las conversaciones. Por eso, cada entrada se
identifica como:

-   **Prompt conservado:** texto que se pudo recuperar de forma literal
    o casi literal.
-   **Reconstrucción fiel:** redacción organizada a partir de la
    consigna y de las instrucciones que se utilizaron durante el
    trabajo. Mantiene el objetivo y los requisitos, pero no debe
    considerarse una transcripción palabra por palabra.

Los prompts de esta documentación están escritos para dejar constancia
del proceso. Cuando se indica "para Gemini", el texto se pega en el
panel de Gemini de Android Studio; no se pega directamente en un archivo
Kotlin.

------------------------------------------------------------------------

## 2. Brief del producto

### Descripción

SoundCraft es un prototipo de aplicación móvil orientado a la
organización y utilización de sonidos y música. Propone una biblioteca
de sonidos representados mediante pads, que se pueden ordenar por
categorías y seleccionar desde una cuadrícula.

La interfaz contempla un reproductor visual y una pantalla para importar
y catalogar archivos de audio en formatos `.mp3` y `.wav`.

### Identidad visual

-   Tema oscuro obligatorio.
-   Alto contraste y botones táctiles amplios.
-   Estética de estudio musical con detalles neón.
-   Colores principales:
    -   Fondo oscuro: `#121018`.
    -   Superficie: `#1E1A2B`.
    -   Violeta neón: `#B388FF`.
    -   Rosa eléctrico: `#FF4081`.
    -   Cian: `#00E5FF`.
    -   Amarillo: `#FFD600`.
    -   Verde: `#00E676`.

### Alcance de esta versión

La versión desarrollada es un **prototipo visual e interactivo**. La
autenticación, la reproducción de audio y la importación de archivos se
representan visualmente o se simulan. No se incorporaron una base de
datos ni servicios externos para esas funciones.

------------------------------------------------------------------------

## 3. Prompts de definición y diseño

### 3.1. Definición de la interfaz principal

**Tipo:** Reconstrucción fiel de la consigna de diseño.

**Prompt:**

> Diseñar la interfaz de una aplicación móvil llamada SoundCraft,
> destinada a organizar y utilizar sonidos y música. La pantalla
> principal debe tener una matriz de 4 columnas por 4 filas, con 16 pads
> de sonido. Incorporar un selector de categorías y una barra de
> reproducción en la parte inferior.
>
> Mantener un tema oscuro obligatorio, alto contraste y botones grandes,
> cómodos para la interacción táctil. Utilizar una estética moderna
> relacionada con la producción musical, con acentos de colores neón.
>
> La propuesta debe estar pensada para desarrollarse en Android Studio
> utilizando Kotlin, Jetpack Compose y Material 3.

### 3.2. Diseño de la pantalla de importación

**Tipo:** Prompt conservado parcialmente y reconstruido para
documentarlo.

**Consigna recuperada:** se solicitó maquetar una interfaz que
permitiera seleccionar archivos de audio exclusivamente `.mp3` o `.wav`,
catalogarlos según el criterio del usuario, generar una imagen de la
interfaz y preparar el prompt para Gemini en Android Studio.

**Prompt organizado:**

> Siguiendo los mismos lineamientos visuales utilizados en SoundCraft,
> diseñá una pantalla de importación de sonidos.
>
> La interfaz debe permitir seleccionar archivos de audio únicamente en
> formatos `.mp3` y `.wav`, ingresar un nombre para el sonido y
> clasificarlo según una categoría elegida por el usuario.
>
> Respetá el tema oscuro, los colores neón, el alto contraste, los
> botones amplios y el lenguaje visual de la pantalla principal.
>
> Prepará una propuesta visual de la interfaz y un prompt para
> implementar esa pantalla en Android Studio con Kotlin, Jetpack Compose
> y Material 3.

### 3.3. Diseño de las pantallas de acceso

**Tipo:** Reconstrucción fiel basada en los requisitos del proyecto.

**Prompt:**

> Diseñá las pantallas de Login y Registro para SoundCraft, manteniendo
> la identidad visual del proyecto: fondo oscuro, superficies en tonos
> violetas y acentos neón.
>
> Login debe incluir campos para correo electrónico y contraseña, un
> botón para iniciar sesión y un enlace para ir al registro.
>
> Registro debe incluir campos para nombre, correo electrónico,
> contraseña y confirmación de contraseña, además de un botón para
> registrarse y un enlace para volver al Login.
>
> Utilizá componentes visuales de Material 3 y botones y campos de texto
> amplios. Las pantallas forman parte de un prototipo visual, por lo que
> no es necesario implementar autenticación real.

------------------------------------------------------------------------

## 4. Prompts para Android Studio y Gemini

### 4.1. Creación del documento de requerimientos `soundcraft_req.md`

**Tipo:** Prompt conservado parcialmente y reconstruido.

**Consigna recuperada:** se pidió producir un archivo
`soundcraft_req.md` que reuniera las definiciones de funcionamiento de
la aplicación, los dominios y su arquitectura dentro de Android Studio.

**Prompt organizado:**

> A partir de las definiciones realizadas para SoundCraft, generá un
> archivo llamado `soundcraft_req.md` en la raíz del proyecto.
>
> El documento debe incluir:
>
> 1.  Descripción general y objetivo de la aplicación.
> 2.  Requerimientos funcionales y no funcionales.
> 3.  Descripción de las pantallas y sus funciones.
> 4.  Dominios principales de la aplicación: Auth, Sound Catalog, Player
>     e Import.
> 5.  Arquitectura y organización propuesta de paquetes dentro de
>     Android Studio.
> 6.  Lineamientos visuales y componentes principales.
> 7.  Flujo de navegación entre pantallas.
>
> Considerá que se trata de un prototipo visual desarrollado con Kotlin,
> Jetpack Compose y Material 3.

### 4.2. Preparación de la estructura del proyecto

**Tipo:** Reconstrucción fiel del trabajo realizado con Gemini.

**Prompt:**

> Revisá la estructura actual del proyecto SoundCraft en Android Studio.
> El proyecto utiliza Kotlin, Jetpack Compose y Material 3.
>
> Organizá el código de manera clara, separando:
>
> -   `ui/theme`: colores y tema visual.
> -   `ui/components`: componentes reutilizables.
> -   `ui/screens`: pantallas de la aplicación.
> -   `ui/navigation`: navegación.
> -   `data/mock`: datos de prueba.
>
> Antes de realizar cambios, verificá la estructura existente y evitá
> modificar archivos que no sean necesarios. Mantené el proyecto
> compilable.

### 4.3. Implementación del tema oscuro neón

**Tipo:** Reconstrucción fiel.

**Prompt:**

> Implementá el sistema visual de SoundCraft en los archivos de tema de
> Jetpack Compose.
>
> Utilizá una paleta oscura con estos colores principales:
>
> -   `DarkBackground`: `#121018`.
> -   `DarkSurface`: `#1E1A2B`.
> -   `DarkSurfaceVariant`: `#2B243B`.
> -   `NeonPurple`: `#B388FF`.
> -   `NeonPink`: `#FF4081`.
> -   `NeonCyan`: `#00E5FF`.
> -   `NeonYellow`: `#FFD600`.
> -   `NeonGreen`: `#00E676`.
>
> Definí el esquema de colores de Material 3 y una función de tema
> llamada `SoundcraftTheme`. Mantené la compatibilidad con el tema
> anterior si ya existe una referencia a él. No cambies la estructura de
> las pantallas.

### 4.4. Creación de datos de prueba para los pads

**Tipo:** Reconstrucción fiel.

**Prompt:**

> Creá el archivo `data/mock/MockSoundData.kt` para proporcionar datos
> de prueba a la biblioteca de SoundCraft.
>
> Definí un modelo `SoundPadItem` que contenga los datos necesarios para
> representar cada pad, como identificador, nombre, categoría, formato y
> color.
>
> Prepará 16 sonidos de ejemplo, organizados en cuatro categorías:
> Drums, Bass, Synths y FX. Cada categoría debe contener cuatro sonidos.
>
> Utilizá formatos `.mp3` y `.wav` como datos de ejemplo. Incluí también
> las categorías disponibles para el filtro, incluyendo la opción Todos.
>
> No implementes reproducción real ni almacenamiento persistente.

### 4.5. Creación de componentes reutilizables

**Tipo:** Reconstrucción fiel.

**Prompt:**

> Creá componentes reutilizables para la interfaz de SoundCraft
> utilizando Kotlin, Jetpack Compose y Material 3. Ubicalos en
> `ui/components`.
>
> Implementá:
>
> 1.  `SoundcraftTextField`: campo de texto con el estilo oscuro y neón
>     de la aplicación, con opción para contraseña.
> 2.  `SoundPad`: pad cuadrado que muestre nombre, categoría y formato
>     del sonido, con un estado visual de selección.
> 3.  `CategoryChip`: filtro visual para seleccionar categorías.
> 4.  `AudioPlayerBar`: barra inferior de reproducción con información
>     del sonido seleccionado, controles visuales de Play/Pause y
>     progreso simulado.
>
> Reutilizá los colores del tema y mantené una apariencia consistente.
> No agregues dependencias externas ni implementes reproducción de audio
> real.

### 4.6. Creación de las cuatro pantallas

**Tipo:** Reconstrucción fiel basada en la instrucción utilizada.

**Prompt:**

> Implementá las pantallas principales de SoundCraft dentro de
> `ui/screens`, utilizando Kotlin, Jetpack Compose y Material 3.
>
> Creá los siguientes archivos:
>
> -   `LoginScreen.kt`
> -   `RegisterScreen.kt`
> -   `LibraryScreen.kt`
> -   `ImportSoundScreen.kt`
>
> Requisitos:
>
> **LoginScreen:** logotipo, encabezado, campos de correo y contraseña,
> botón para iniciar sesión y enlace a Registro.
>
> **RegisterScreen:** campos de nombre, correo, contraseña y
> confirmación, botón para registrarse y enlace para volver a Login.
>
> **LibraryScreen:** encabezado, botón IMPORTAR, filtros de categorías,
> cuadrícula de 16 pads en cuatro columnas y reproductor visual
> inferior.
>
> **ImportSoundScreen:** selección simulada de archivo, limitada a
> `.mp3` y `.wav`, campo para el nombre del pad, selección de categoría
> y confirmación visual al guardar.
>
> Utilizá los componentes reutilizables y los datos de prueba ya
> creados. Mantené el diseño oscuro con acentos neón.
>
> Importante: esta versión es un prototipo visual. No implementes
> autenticación real, reproducción real de audio, importación real de
> archivos, base de datos ni dependencias adicionales.
>
> No modifiques todavía `MainActivity.kt` ni la navegación. Al
> finalizar, informá qué archivos creaste o modificaste y si hay
> errores.

### 4.7. Implementación de la navegación e integración

**Tipo:** Reconstrucción fiel del pedido de integración.

**Prompt:**

> Implementá la navegación de SoundCraft creando `AppNavigation.kt`
> dentro de `ui/navigation`.
>
> La aplicación debe comenzar en LoginScreen y permitir el siguiente
> recorrido:
>
> -   Login → Library al presionar INICIAR SESIÓN.
> -   Login → Register al seleccionar el enlace de registro.
> -   Register → Library al presionar REGISTRARSE.
> -   Register → Login al seleccionar el enlace para volver.
> -   Library → ImportSound al presionar IMPORTAR.
> -   ImportSound → Library al volver o guardar y catalogar el pad.
>
> Utilizá un estado para controlar la pantalla actual, sin incorporar
> una biblioteca externa de navegación.
>
> Integrá `AppNavigation()` en `MainActivity.kt` y aplicá
> `SoundcraftTheme`.
>
> Conservá el diseño y la estructura de las pantallas ya implementadas.
> No realices cambios innecesarios en `LibraryScreen.kt` ni en otros
> componentes. Si necesitás modificar algún archivo existente, explicá
> primero qué cambio es necesario.
>
> Al finalizar, verificá que las pantallas estén conectadas y que el
> proyecto no tenga errores de compilación.

### 4.8. Revisión general del proyecto

**Tipo:** Prompt conservado.

**Prompt utilizado:**

> Antes de continuar, realizá una revisión general del proyecto
> SoundCraft. Verificá que todas las pantallas estén correctamente
> conectadas, que los botones de navegación funcionen y que no existan
> errores de compilación. No realices cambios adicionales si no son
> necesarios. Informame si está todo listo para ejecutar la aplicación.

### 4.9. Comprobación de compilación con Gradle

**Tipo:** Prompt conservado.

**Prompt utilizado:**

> Necesito que verifiques si el proyecto SoundCraft compila
> correctamente. Ejecutá una comprobación de compilación de Gradle para
> el módulo app, sin modificar ningún archivo. Si hay errores, mostrame
> el mensaje completo y explicame cómo solucionarlos. Si compila
> correctamente, informame el resultado.

**Resultado informado por Gemini:**

-   Tarea ejecutada: `:app:assembleDebug`.
-   Estado: `BUILD SUCCESSFUL`.
-   Errores: 0.

### 4.10. Incorporación de vistas previas de Jetpack Compose

**Tipo:** Prompt conservado.

**Prompt utilizado:**

> Quiero poder visualizar las pantallas de SoundCraft desde Android
> Studio usando Jetpack Compose Preview, sin ejecutar un emulador.
>
> Revisá los archivos LoginScreen.kt, RegisterScreen.kt,
> LibraryScreen.kt e ImportSoundScreen.kt.
>
> Agregá funciones @Preview para cada pantalla, respetando el diseño
> actual, los colores, los componentes y la estructura existente.
>
> Las vistas previas deben poder renderizarse de forma independiente,
> utilizando datos de prueba y callbacks vacíos cuando sea necesario.
>
> No modifiques la navegación, MainActivity ni el funcionamiento de las
> pantallas. No elimines ni reemplaces código existente.
>
> Al terminar, verificá que no haya errores de compilación e indicame
> qué archivos modificaste.

------------------------------------------------------------------------

## 5. Casos de uso implementados en el MVP

Para documentar el MVP del Seminario, se identifican los siguientes
casos de uso visuales:

### CU-01 --- Acceso a la aplicación

**Actor:** usuario.

**Flujo:** 1. El usuario visualiza la pantalla Login. 2. Completa los
campos de correo y contraseña. 3. Presiona INICIAR SESIÓN. 4. La
aplicación navega a la Librería.

**Estado:** flujo visual implementado; no valida credenciales reales.

### CU-02 --- Registro de usuario

**Actor:** usuario.

**Flujo:** 1. Desde Login, el usuario selecciona el enlace de registro.
2. La aplicación muestra el formulario de Registro. 3. El usuario
completa los campos. 4. Presiona REGISTRARSE. 5. La aplicación navega a
la Librería.

**Estado:** flujo visual implementado; no crea una cuenta real.

### CU-03 --- Explorar la biblioteca de sonidos

**Actor:** usuario.

**Flujo:** 1. El usuario ingresa a la Librería. 2. Visualiza 16 pads
organizados en cuatro columnas. 3. Selecciona una categoría. 4. La
cuadrícula se actualiza según el filtro. 5. Selecciona un pad y se
actualiza la información del reproductor visual.

**Estado:** interacción visual implementada con datos de prueba.

### CU-04 --- Importar y catalogar un sonido

**Actor:** usuario.

**Flujo:** 1. Desde la Librería, selecciona IMPORTAR. 2. Se abre la
pantalla de Importación. 3. El usuario completa el nombre del sonido y
elige una categoría y formato. 4. Presiona GUARDAR Y CATALOGAR PAD. 5.
La interfaz muestra una confirmación y permite regresar a la Librería.

**Estado:** flujo visual simulado; no importa ni guarda archivos reales.

------------------------------------------------------------------------

## 6. Evidencias y estado del proyecto

-   **Repositorio público:**
    https://github.com/MariaLuzPaezTello/SoundCraft
-   **Entorno:** Android Studio.
-   **Lenguaje:** Kotlin.
-   **Interfaz:** Jetpack Compose y Material 3.
-   **Pantallas:** Login, Registro, Librería e Importación.
-   **Componentes:** SoundcraftTextField, SoundPad, CategoryChip y
    AudioPlayerBar.
-   **Datos:** 16 sonidos de prueba distribuidos en cuatro categorías.
-   **Navegación:** integrada mediante AppNavigation.
-   **Compilación:** `:app:assembleDebug` con resultado
    `BUILD SUCCESSFUL`.
-   **Vistas previas:** incorporadas con Jetpack Compose Preview.

### Alcance pendiente

La versión documentada es un MVP visual e interactivo. Para convertirlo
en una aplicación plenamente funcional sería necesario desarrollar,
entre otras cosas:

-   Autenticación y registro reales.
-   Acceso al almacenamiento y selección real de archivos.
-   Reproducción de audio.
-   Persistencia de sonidos y categorías.

------------------------------------------------------------------------

## 7. Relación con la consigna del Seminario

Según el apartado de Seminario de la consigna, este documento acompaña
los siguientes elementos:

  -------------------------------------------------------------------------------------
  Entregable                          Estado
  ----------------------------------- -------------------------------------------------
  Brief del producto                  Documentado en este archivo

  Mockups                             Realizados durante la etapa de diseño; adjuntar
                                      las imágenes correspondientes a la entrega

  MVP de Android (proyecto Android    Desarrollado como prototipo visual e interactivo
  Studio)                             

  Prompts (.md)                       Reunidos en este documento

  GitHub                              https://github.com/MariaLuzPaezTello/SoundCraft
  -------------------------------------------------------------------------------------

**Importante:** la consigna también menciona para el examen final un MVP
de Android que cumpla al menos dos casos de uso. Los casos CU-01 a CU-04
de este documento describen los flujos implementados en el prototipo
actual. Conviene confirmar con el docente si el alcance simulado es
suficiente para la instancia final o si se requiere funcionalidad real.

------------------------------------------------------------------------

*Documento de registro del proceso de desarrollo de SoundCraft ---
Seminario.*

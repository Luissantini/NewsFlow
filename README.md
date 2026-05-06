# 📰 NewsFlow

**NewsFlow** es una aplicación de noticias moderna para Android construida con las últimas tecnologías y siguiendo los principios de **Clean Architecture**. La app consume datos de la [NewsAPI](https://newsapi.org/) para mostrar los titulares más importantes de manera eficiente y escalable.

---

## 🏗️ Arquitectura

El proyecto está estructurado en tres capas principales para garantizar la separación de conceptos y la facilidad de testeo:

* **Domain:** Contiene los modelos de negocio (`Article`) y las interfaces de los repositorios. Es una capa puramente Kotlin, sin dependencias de Android.
* **Data:** Implementa la lógica de datos. Incluye **Retrofit** para llamadas a la API, los **DTOs** (Data Transfer Objects) y los **Mappers** para transformar datos crudos en modelos de dominio.
* **Presentation:** Implementada con **Jetpack Compose**. Utiliza el patrón **MVVM** (Model-View-ViewModel) para gestionar el estado de la UI de forma reactiva.



---

## 🛠️ Tech Stack

* **Kotlin**: Lenguaje principal.
* **Jetpack Compose**: UI declarativa moderna.
* **Dagger Hilt**: Inyección de dependencias para desacoplar componentes.
* **Retrofit & OkHttp**: Consumo de servicios REST y logging de red.
* **Coil**: Carga de imágenes asíncronas y optimizadas.
* **Kotlin Coroutines & Flow**: Manejo de asincronía y flujos de datos.
* **Version Catalog (TOML)**: Gestión centralizada de dependencias.

---

## 🚀 Configuración del Proyecto

Para proteger la integridad de los datos, la **API KEY** no está incluida en el repositorio. Para ejecutar el proyecto:

1. Obtén tu propia llave en [NewsAPI.org](https://newsapi.org/).
2. En tu archivo `local.properties` (en la raíz del proyecto), añade la siguiente línea:
   ```properties
   NEWS_API_KEY=tu_api_key_aqui

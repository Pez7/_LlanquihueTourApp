
Llanquihue Tour App

👤 Autor del proyecto


Nombre completo: María Paz Rojas
Sección: 2026_202_OL_PRY2202_24613392_PCT
Carrera: Analista Programador Computacional
Sede: Online


📘 Descripción general del sistema

Este proyecto corresponde a la Evaluación Final Transversal (EFT) de la asignatura Desarrollo Orientado a Objetos I, y representa el prototipo de software para Llanquihue Tour, una agencia de turismo con más de 10 años de experiencia en la Región de Los Lagos, cuya oferta incluye excursiones personalizadas, tours gastronómicos, paseos lacustres y rutas culturales.

El sistema busca resolver las problemáticas de gestión manual de la agencia (información duplicada, ausencia de categorización de personas y falta de trazabilidad en clientes, guías y proveedores) mediante un prototipo modular en Java, orientado a objetos, que aplica:


Encapsulamiento, constructores, getters/setters y toString() en todas las clases.
Composición entre clases (Persona/Proveedor con Direccion y Rut).
Validación de RUT mediante una excepción personalizada (RutInvalidoException).
Herencia (Persona → Cliente, GuiaTuristico).
Una interfaz reutilizable (Registrable) con listas polimórficas y uso de instanceof para validaciones de tipo.
Colecciones gestionadas en memoria, con carga de datos de prueba desde un archivo .txt externo.


A diferencia de versiones anteriores del proyecto (semanas previas de la asignatura), esta entrega funciona completamente por consola (sin interfaz gráfica), mediante un menú interactivo.

📁 src/
├── app/     # Punto de entrada del sistema (Main.java) y menú de consola
├── model/   # Clases de dominio (Persona, Cliente, GuiaTuristico, Proveedor, Direccion, Rut, Registrable)
├── data/    # Gestión de colecciones y carga de datos (GestorEntidades, GestorDatos)
├── utils/   # Excepciones personalizadas (RutInvalidoException)
📁 resources/
└── datos.txt   # Datos de prueba (Clientes, Guías Turísticos y Proveedores) 


| Clase | Paquete | Rol |
|---|---|---|
| Persona | model | Clase base con nombre, RUT, correo, teléfono y dirección (composición). Superclase de Cliente y GuiaTuristico. |
| Cliente | model | Hereda de Persona. Agrega número de reservas. Implementa Registrable. |
| GuiaTuristico | model | Hereda de Persona. Agrega idioma y tipo de tour. Implementa Registrable. |
| Proveedor | model | Clase independiente (no hereda de Persona, ya que puede representar una empresa). Agrega tipo de proveedor y razón social. Implementa Registrable. |
| Direccion | model | Clase de apoyo usada por composición en Persona y Proveedor. |
| Rut | model | Encapsula y valida el formato del RUT, lanzando RutInvalidoException si es inválido. |
| Registrable | model | Interfaz que define registrar() y mostrarDatos(), implementada por Cliente, GuiaTuristico y Proveedor. |
| RutInvalidoException | utils | Excepción personalizada (checked) para RUTs con formato inválido. |
| GestorDatos | data | Clase utilitaria que lee resources/datos.txt y construye los objetos del modelo. |
| GestorEntidades | data | Administra las colecciones de registros (desde archivo y manuales), permite listar, filtrar por idioma y detectar clientes VIP. |
| Main | app | Clase principal; despliega el menú de consola y coordina la carga, listado, agregado y filtrado de registros. |



🖥️ Funcionamiento del sistema

Al ejecutar el programa, se cargan automáticamente los registros de prueba desde resources/datos.txt (Clientes, Guías Turísticos y Proveedores). Luego se despliega un menú de consola con las siguientes opciones:


Listar registros cargados desde archivo
Listar registros agregados manualmente
Listar todos los registros
Agregar un nuevo registro manualmente (Cliente, Guía Turístico o Proveedor, solicitando los datos por consola)
Filtrar guías turísticos por idioma
Salir


Al listar los registros, el sistema recorre una lista polimórfica de tipo List<Registrable> y muestra el resumen de cada objeto según su tipo real, marcando además con instanceof a los clientes con más de 4 reservas como "Cliente VIP".

⚙️ Instrucciones para ejecutar el proyecto


Clona el repositorio:


   git clone https://github.com/TU-USUARIO/TU-REPOSITORIO


Abre el proyecto en NetBeans.
Verifica que el archivo resources/datos.txt exista en la raíz del proyecto (junto a src, build.xml, nbproject).
Ejecuta la clase principal Main, ubicada en el paquete app, con el botón Run (▶) o F6.
Interactúa con el menú desde la consola de salida de NetBeans (pestaña Output).


Repositorio GitHub: https://github.com/TU-USUARIO/TU-REPOSITORIO

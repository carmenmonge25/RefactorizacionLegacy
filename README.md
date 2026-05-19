# AEE: "Limpieza de Primavera"

## Refactorización de Código Legado

# 1\. Contextualización Profesional: El desafío del "Código Legado"

**Imagina la siguiente situación real**: acabas de incorporarte como desarrollador/a Junior en una empresa de software consolidada. En tu primer día, María, la *Senior Developer* de tu equipo, te asigna una tarea crítica y te dice:

*"Tenemos una clase del sistema de facturación antiguo que calcula los descuentos de nuestros clientes. Funciona perfectamente y en producción no da errores, pero internamente es un desastre ilegible. Procesa más de 10.000 transacciones al día, por lo que nadie se ha atrevido a tocarlo en años. Necesitamos que lo limpies sin romper absolutamente nada antes de integrarlo en la nueva plataforma web y móvil".*

Tu misión en esta sesión es enfrentarte a este miedo habitual en la industria. Aplicarás la **Regla del Boy Scout** ("deja el código siempre más limpio de como lo encontraste") y exprimirás las herramientas de tu Entorno Integrado de Desarrollo (IDE) para refactorizar este módulo, eliminando por completo su deuda técnica. Fíjate que no vas a programar funcionalidades nuevas; vas a actuar como un cirujano del código.

# 2\. Resultados de Aprendizaje

Esta actividad evalúa de forma directa y específica el siguiente Resultado de Aprendizaje (RA) del módulo, clave para tu futuro profesional:

**RA 4**: Optimiza y documenta código, aplicando herramientas de refactorización y control de versiones.

a) Se han utilizado las herramientas de refactorización del entorno de desarrollo.  
b) Se ha optimizado el código reduciendo su complejidad y mejorando su legibilidad.  
d) Se ha documentado el código fuente utilizando el formato estándar del lenguaje.  
f) Se han utilizado herramientas de control de versiones para gestionar los cambios.

# 3\. Fechas, Organización y Metodología de Trabajo

La actividad se realizará íntegramente en el aula. Al encontrarnos en la recta final del tercer trimestre, contaremos con una sesión completa de casi 3 horas para trabajar sin prisas.

**Modalidad de Trabajo: Programación en Parejas (*Pair Programming*)**

No trabajarás solo. Se organizarán en parejas utilizando un único ordenador. Deberéis alternar los siguientes roles cada 30 minutos:

1. **El Piloto (Driver):** Es quien tiene las manos en el teclado y el ratón. Se concentra en escribir el código, aplicar los atajos del IDE y ejecutar las pruebas.  
2. **El Copiloto (Navigator):** Revisa cada línea que se escribe, piensa en la estructura general, revisa el guión de la actividad y busca posibles fallos lógicos antes de que ocurran.  
* **Entrega final:** Al finalizar la clase, subiréis el enlace de vuestro repositorio Git.  
  **Nota**: cada vez que haya cambio de rol se anunciará haciendo *commit*.

# 4\. Material de Partida: El "Código Legado" y su Red de Seguridad

Clona el repositorio base proporcionado en la plataforma. En su interior encontraréis la clase FacturacionLegacy.java con el siguiente método. Observad que su Complejidad Ciclomática es altísima y la carga cognitiva necesaria para entenderlo agota a cualquier programador:

// Método a refactorizar  
public double cT(double m, int tC, boolean dV) {  
    if (m \> 0) {  
        if (tC \== 1) {  
            if (dV \== true) return m \- (m \* 0.25);  
            else return m \- (m \* 0.15);  
        } else {  
            if (tC \== 2) {  
                return m \- (m \* 0.05);  
            } else {  
                return m;  
            }  
        }  
    } else {  
        return 0;  
    }  
}

Junto a este desastre, tendréis un archivo FacturacionLegacyTest.java. Esta es **vuestra red de seguridad**. Contiene pruebas que envían datos al método y comprueban que el resultado matemático sea correcto. Nunca debéis modificar los tests.

# 5\. Instrucciones Paso a Paso

Para llevar a cabo esta limpieza con éxito, seguiréis un procedimiento estrictamente profesional dividido en tres fases. Lo importante aquí es ir poco a poco.

## Fase 1: Análisis de la Deuda Técnica

1. **Verificación inicial.** Ejecuta los tests unitarios. Todo debe salir en verde. Esto os garantiza que el código original, por muy feo que sea, funciona.

Creacion proyecto  
<img width="206" height="75" alt="image" src="https://github.com/user-attachments/assets/bbf1a37f-ea36-4bbd-88ad-a84afaad7f83" />

Creacion paquete  
<img width="242" height="167" alt="image" src="https://github.com/user-attachments/assets/cd5f89eb-8645-4aaf-a04c-a41842806cc2" />

Creacion Test  
<img width="654" height="869" alt="image" src="https://github.com/user-attachments/assets/449eaa10-5c3d-4760-8042-21bc6e1c7273" />

Libreria JUnit 5  
<img width="347" height="382" alt="image" src="https://github.com/user-attachments/assets/648d66ea-f94d-46b6-b766-0e7609681341" />

Validacion Tests  
<img width="694" height="717" alt="image" src="https://github.com/user-attachments/assets/ace07fa1-d8a7-4cad-b686-d9b528331233" />

   
2. **Oler el código (*Code Smells*).** El Copiloto anotará en un bloc de notas los tres grandes problemas de este código:  
   * **Números mágicos.** ¿Qué significa 0.25 o 0.15? Son valores *hardcodeados* sin contexto. Si mañana el IVA o el descuento cambian, ¿dónde los buscamos?  
   * **Variables sin significado.** Nombres como cT, m, tC o dV no aportan ninguna semántica. Nos obligan a adivinar.  
   * **Código Spaghetti.** La anidación de múltiples if-else crea una estructura en forma de flecha \> que hace casi imposible seguir el flujo lógico de ejecución.

## Fase 2: Refactorización Asistida por el IDE (Quirófano abierto)

1. **Renombrado Seguro.** Utiliza **exclusivamente las herramientas automáticas del IDE** para cambiar los nombres de las variables en todo el documento a la vez, sin riesgo de errores tipográficos.  
   * *Sugerencia:* cT por calcularTotal, m por importeBase, tC por tipoCliente, dV por esSocioVip.* *
Refactorización del nombre del método cT -> calcularTotal  
<img width="500" height="285" alt="image" src="https://github.com/user-attachments/assets/282f996d-968a-4cad-bb59-fcfd51b49e61" />  

Refactorización del nombre del parámetro m -> importeBase  
<img width="498" height="264" alt="Captura de pantalla 2026-05-19 140050" src="https://github.com/user-attachments/assets/49771c68-beae-4a43-a2ca-44418cf7f16f" />  

Refactorización del nombre del parámetro tC -> tipoCliente  
<img width="501" height="281" alt="image" src="https://github.com/user-attachments/assets/d5044084-3ef5-4936-8ee1-6f37735a1299" />  

Refactorización del nombre del parámetro dV -> esSocioVip  
<img width="505" height="278" alt="image" src="https://github.com/user-attachments/assets/25017dbe-e7a9-42bd-8b97-de5edb4b0794" />  

2. **Extracción de Constantes.** Selecciona los números mágicos (0.25, 0.15, etc.) y usa la herramienta de extracción del IDE para crear constantes private static final en la parte superior de la clase. Usa nombres autoexplicativos como DESCUENTO\_VIP o DESCUENTO\_ESTANDAR.

Refactorización de extracción del dato 0.25 a la constante DESCUENTO_VIP  
<img width="491" height="235" alt="image" src="https://github.com/user-attachments/assets/a3ff6b77-2bd7-4b79-89c8-6f35c669ab35" />  
Hemos renombrado el nombre de la variable a DESCUENTO_VIP_EXTRA  
<img width="500" height="266" alt="image" src="https://github.com/user-attachments/assets/5230a764-b6d6-4684-b963-c1e261f5215a" />  


Refactorización de extracción del dato 0.15 a la constante DESCUENTO_ESTANDAR  
<img width="490" height="246" alt="image" src="https://github.com/user-attachments/assets/cae883a7-5d4e-4eca-a1fa-f36776a07fce" />  
Hemos renombrado la constante a DESCUENTO_VIP  
<img width="506" height="108" alt="image" src="https://github.com/user-attachments/assets/64b6e4fb-f13e-46d3-ab58-d49b32dda356" />  


Refactorización de extracción del dato 0.15 a la constante DESCUENTO_ESTANDAR  
<img width="489" height="242" alt="Captura de pantalla 2026-05-19 141210" src="https://github.com/user-attachments/assets/0dd57c6d-0c40-4046-8fef-c5bdeef43b86" />  


RESULTADO:  
<img width="648" height="631" alt="image" src="https://github.com/user-attachments/assets/713aa4c3-8a68-4501-871a-70e76188cb4b" />  


3. **Cláusulas de Guarda (*Guard Clauses*).** Modifica la estructura de control para "aplanar" el código. Invierte las condiciones lógicas y utiliza retornos tempranos (return) para eliminar **todos** los bloques “*else”*.  

<img width="642" height="490" alt="image" src="https://github.com/user-attachments/assets/119c6e5f-5e48-451d-a8ea-ff169c216dca" />  


## Fase 3: Verificación, Documentación y Entrega

1. **Validación constante**. Vuelve a ejecutar los tests unitarios tras CADA pequeño cambio. ¡Deben seguir en verde\! Si alguno falla, significa que habéis roto el negocio. Usad el control de versiones (Git) para deshacer los cambios y volver a un estado seguro.

Tras realizar todos los cambios los test siguien siendo válidos
<img width="615" height="861" alt="image" src="https://github.com/user-attachments/assets/7e49770a-87c3-4db1-aa67-f4da793e89b0" />

2. **Documentación profesional**. Genera la documentación JavaDoc escribiendo / y pulsando *Enter* justo encima del método. Rellena los campos @param explicando qué recibe la función y el @return detallando qué devuelve.
El IDE añade automaticamente la siguiente documentación  
<img width="543" height="126" alt="image" src="https://github.com/user-attachments/assets/12815ab1-0c4b-499f-af3a-6a435f92bd23" />

Javadoc:
<img width="1919" height="342" alt="image" src="https://github.com/user-attachments/assets/cfcc802a-554d-43af-a88a-c2a38970c869" />
<img width="1889" height="830" alt="image" src="https://github.com/user-attachments/assets/ae9cd7b3-8ef7-4056-a94b-4b24245baa81" />

3. **Guardado en el repositorio:** Realiza un *commit* semántico en vuestro repositorio que describa exactamente lo que habéis hecho.  
   * *Ejemplo:* git commit \-m "refactor: reducción de complejidad ciclomática mediante cláusulas de guarda y nombrado semántico".



# 6\. Uso de la IA

Si necesitas consultar o proponer cualquier consulta en forma de *prompt* a cualquier *chatbot* o Agente, es necesario abrir un apartado en tu trabajo que se llame “Consultas IA”. 

Seguidamente, apunta el *prompt* que has diseñado así como la respuesta otorgada.

| \# 1 |  |
| ----- | :---- |
| **Agente:** |  |
| **Prompt:** |  |
| **Respuesta textual:** |  |


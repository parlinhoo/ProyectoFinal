# Proyecto Final Programación II
Integrantes (Grupo 21):
- Bastián Ceballos Zapata
- Fabián González Uribe

El proyecto final tiene como objetivo desarrollar un "Sistema de reserva de asientos de autobús", junto a con su interfaz gráfica, para que el personal de una empresa de autobús pueda elegir y reservar asientos de forma conveniente por su cliente.

## Diagrama UML

![Diagrama UML](https://github.com/parlinhoo/ProyectoFinal/blob/main/UML.png?raw=true)

## Diagrama de Casos de Uso

![Diagrama de Casos de Uso](https://github.com/parlinhoo/ProyectoFinal/blob/main/Use%20Case%20Diagram.png?raw=true)

## Patrones Utilizados

-**Builder:** Nos permitió crear buses a nuestro antojo, con la cantidad de asientos que quisiéramos, y con cualquier distribución, asi tendríamos infinitas variedades de buses, siempre con uno o dos pisos. 


## Capturas de Pantalla de la Interfaz

### Primera Pagina
Permite al usuario elegir desde y a donde se hará el viaje, asi como también la fecha del mismo
![Interfaz de la Aplicación](https://github.com/parlinhoo/ProyectoFinal/blob/main/Captura1.PNG?raw=true)
### Segunda Pagina
Permite al usuario elegir entre todos los buses disponibles
![Interfaz de la Aplicación](https://github.com/parlinhoo/ProyectoFinal/blob/main/Captura2.PNG?raw=true)
### Tercera Página
Permite al usuario ver y elegir entre los asientos disponibles en el bus elegido, al igual que confirmar el pago para reservar los asientos elegidos
![Interfaz de la Aplicación](https://github.com/parlinhoo/ProyectoFinal/blob/main/Captura3.PNG?raw=true)

## Decisiones Tomadas durante el Proyecto

La mayoría de decisiones fueron tomadas en la planificación del proyecto, pues siempre tuvimos claro que es lo que queríamos: Una interfaz simple de entender pero no por ello menos compleja, para ello, decidimos seccionar la interfaz en 3 partes (como ya se vio antes), siendo lo mas difícil de definir la lógica de los viajes y la asignación de buses, inclinándonos finalmente por algo más realista, creando los viajes y los buses por separado, asignando cada bus a un viaje determinado.

## Problemas Encontrados y Autocrítica

Nuestro mayor problema fue desconocer nuestros limites, pues siempre buscamos lo mejor o lo más completo, pero esto no siempre fue posible de implementar, ya sea por como estaba estructurado el código o simplemente por el uso de la biblioteca Swing.



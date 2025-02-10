# Gestion Rectificadora Malvinas Back
API en SpringBoot que unicamente realiza las request conectadas a una BDD en MySQL donde almacena los clientes, pedidos, presupuestos e items provenientes del Front.
<h2>Para Correrlo:</h2>
<ul>
<li>Correr servidor xampp</li>
<li>Crear BDD en mySQL con el nombre <strong>gestionrectificadoramalvinas</strong></li>
<li>Correr proyecto SpringBoot</li>
<li>Correr proyecto angular</li>
</ul>
<h2>Herramientas</h2>
<p>GET, GETById, POST, PUT, PATCH, DELETE</p>
<ul>
<li>Cliente</li>
<li>Presupuestos</li>
<li>Pedidos</li>
<li>Items esta incluido como una clase @embeddable en la clase Presupuesto</li>
</ul>
<p>Se opto por hacer todas las herramientas para cada una de las entidades. Actualmente, en esta version del proyecto, solo se usa los metodos GET, GETById, POST, PUT y DELETE, dejando en las manos de alguna nueva versión que necesite del resto de los metodos</p>

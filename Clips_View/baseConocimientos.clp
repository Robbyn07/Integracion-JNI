(deftemplate cuestionario
	(slot lejano
		(type STRING)
		(default "cerca") 
	)
	(slot salir
		(type STRING)
		(default "ninguno")
	)
	(slot veces
		(type STRING)
		(default "no")
	)
	(slot factibilidad
		(type STRING)
		(default "si") 
	)
	(slot metodo
		(type STRING)
		(default "otro") 
	)
	(slot acompaniante
		(type STRING)
		(default "no") 
	)
	(slot rutina
		(type STRING)
		(default "no") 
	)
	(slot estabilidad
		(type STRING)
		(default "no") 
	)
	(slot licencia
		(type STRING)
		(default "no") 
	)
)


(deffunction respuesta (?resul)
	(if (<= ?resul 30)
	then
		(printout t "Su puntaje es :" ?resul ". En la actualidad usted no tiene la necesidad de comprar un vehiculo." crlf)
	else (if (>= ?resul 46)
		then
			(printout t "Su puntaje es :" ?resul ". Lo mas conveniente para usted es comprar un carro para poder transportarse." crlf)
		else
			(printout t "Su puntaje es :" ?resul ". Para usted, lo mas adecuado es comprar una moto para su transporte." crlf)
		)
	)
)


(deffunction resultado (?le ?s ?v ?f ?m ?a ?r ?e ?li ?resul)
	(if (= (str-compare ?le "lejos") 0)
	then
		(bind ?resul (+ ?resul 7))
	)

	(if (= (str-compare ?s "ambos") 0)
	then
		(bind ?resul (+ ?resul 10))
	else (if (= (str-compare ?s "ninguno") 0)
		then
			(bind ?resul (+ ?resul 2))
		else
			(bind ?resul (+ ?resul 5))
		)
	)
	
	(if (= (str-compare ?v "si") 0)
	then
		(bind ?resul (+ ?resul 7))
	else
		(bind ?resul (+ ?resul 2))
	)
	
	(if (= (str-compare ?f "si") 0)
	then
		(bind ?resul (+ ?resul 4))
	else
		(bind ?resul (+ ?resul 7))
	)
	
	(if (= (str-compare ?m "bus") 0)
	then
		(bind ?resultado (+ ?resul 5))
	else (if (= (str-compare ?s "taxi") 0)
		then
			(bind ?resul (+ ?resul 9))
		else
			(bind ?resul (+ ?resul 3))
		)
	)
	
	(if (= (str-compare ?a "si") 0)
	then
		(bind ?resul (+ ?resul 4))
	else
		(bind ?resul (+ ?resul 1))
	)
	
	(if (= (str-compare ?r "si") 0)
	then
		(bind ?resul (+ ?resul 7))
	else
		(bind ?resul (+ ?resul 3))
	)
	
	(if (= (str-compare ?e "si") 0)
	then
		(bind ?resul (+ ?resul 5))
	)
	
	(if (= (str-compare ?li "si") 0)
	then
		(bind ?resul (+ ?resul 5))
	)

	(respuesta ?resul)
)


(defrule validar
	(cuestionario (lejano ?le) (salir ?s) (veces ?v) (factibilidad ?f) (metodo ?m) (acompaniante ?a) (rutina ?r) (estabilidad ?e) (licencia ?li))
=>
	(bind ?resul 0)
	(resultado ?le ?s ?v ?f ?m ?a ?r ?e ?li ?resul)	
)


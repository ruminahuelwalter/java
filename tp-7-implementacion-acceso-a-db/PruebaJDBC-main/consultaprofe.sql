select p.Descripcion as Pieza, c.Descripcion as Color,
tp.Descripciondepieza as TipoPieza,
tm.Descripcion as Tamaño, m.Descripcion as Material
from pieza p
inner join color c on c.idColor = p.Color_idColor
inner join tipopieza tp on tp.idTipoPieza = p.TipoPieza_idTipoPieza
inner join tamaño tm on tm.idTamaño = p.Tamaño_idTamaño
inner join material m on m.idMaterial = p.Material_idMaterial
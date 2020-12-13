package com.sberbank.tractor;

/**
 * Абстарактный класс, описывающий управление трактором.
 * Корень всех 'водителей' тракторов.
 */
public abstract class TractorDriver {
   /**
    * Возвращает трактор, которым управляет класс
    */
   public abstract Tractor getTractor();

   /**
    * Запускает цепочку команд управления трактором, эта цепочка может поступать из разных источников
    */
   public abstract void startTractor();
}
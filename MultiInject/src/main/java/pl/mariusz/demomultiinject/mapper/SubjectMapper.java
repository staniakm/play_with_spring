package pl.mariusz.demomultiinject.mapper;


import pl.mariusz.demomultiinject.dto.SubjectDto;
import pl.mariusz.demomultiinject.entity.Subject;

interface SubjectMapper {
    boolean canHandle(SubjectDto dto);

    Subject handle(SubjectDto dto);
}
